package API.TestBot.Services.Impl;

import API.TestBot.Models.User;
import API.TestBot.Models.UserDetails;
import API.TestBot.Repositories.UserDetailsRepository;
import API.TestBot.Repositories.UserRepository;
import API.TestBot.Services.UserDetailsService;
import API.TestBot.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.sql.Timestamp;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;
    private final UserDetailsService userDetailsService;

    public void registrationUser(Update update) {
        if (userRepository.findById(update.getMessage().getChatId()).isEmpty()) {
            long chatId = update.getMessage().getChatId();
            User user = new User(chatId, update.getMessage().getChat().getFirstName(), (new Timestamp(System.currentTimeMillis())));
            UserDetails userDetails = new UserDetails(chatId);
            userRepository.save(user);
            userDetailsRepository.save(userDetails);
        }
    }

    public String userBuyProduct(UserDetails userDetails, User user, int price, String product) {
        if (user.getBalance() < price) {
            return "У вас недостаточно средств на балансе, его можно пополнить в в разделе \"Профиль\"";
        } else {
            userDetailsService.setUserTotalPurchases(userDetails, price);
            user.setBalance(user.getBalance() - price);
            userRepository.save(user);
            return "Ваш товар: \n\n" + product + "\n\nСпасибо за покупку!";
        }
    }
    public String setUserBalance(Update update, User user, UserDetails userDetails) {
        try {
            int valueToDeposit = Integer.parseInt(update.getMessage().getText());
            if (valueToDeposit <= 0) {
                return "Пожалуйста введите число не меньше 1";
            } else {
                user.setBalance(user.getBalance() + valueToDeposit);
                userRepository.save(user);
                userDetails.setTotalDeposit(userDetails.getTotalDeposit() + valueToDeposit);
                userDetails.setDeposit(false);
                userDetailsRepository.save(userDetails);
                return "Вы успешно пополнили баланс на " + valueToDeposit + "\n\nВаш текущий баланс: " + user.getBalance();
            }
        } catch (NumberFormatException e) {
            return "Пожалуйста введите сумму без посторонних символов";
        }
    }
}
