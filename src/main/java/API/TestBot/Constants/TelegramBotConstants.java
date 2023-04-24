package API.TestBot.Constants;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TelegramBotConstants {
    public interface constants {

        String FIRST_LIST = "FIRST_LIST";

        String SECOND_LIST = "SECOND_LIST";

        String BACK = "BACK";

        String ONE_PURCHASE = "ONE_PURCHASE";

        String MULTIPLE_PURCHASES = "MULTIPLE_PURCHASES";

        String FIRST_PRODUCT = "FIRST_PRODUCT";

        String SECOND_PRODUCT = "SECOND_PRODUCT";

        String THIRD_PRODUCT = "THIRD PRODUCT";

        String FOURTH_PRODUCT = "FOURTH PRODUCT";

        String PRODUCT_MISSING = "Извините, в данный момент товар отсутствует";

        String DEPOSIT = "DEPOSIT";

        String YOOMONEY = "YOOMONEY";

        String RULES_TEXT = "\uD83D\uDCCB 1. Общие правила\n" +
                "1.1 Администрация оставляет за собой право вносить любые изменения и дополнения в правила без предупреждения.\n" +
                "1.2 Возврат денежных средств осуществляется только на баланс бота.\n" +
                "1.3 Незнание правил не освобождает от ответственности.\n" +
                "⚠ 2. Покупка товара\n" +
                "2.1 Перед покупкой обязательно ознакомьтесь с описанием товара.\n" +
                "2.2 В случае возникновения проблем покупатель должен незамедлительно написать в поддержку.\n" +
                "2.3 Ответ оператора может занимать до 24 часов (в среднем 7 минут)\n" +
                "✅ 2. Гарантия\n" +
                "2.1 Гарантийное время начинается с момента покупки.\n" +
                "2.2 По истечении гарантийного времени товар возврату не подлежит.\n" +
                "\uD83D\uDCDD 3. Пользовательское соглашение\n" +
                "3.1 Совершая покупки в боте, вы автоматически соглашаетесь с вышеперечисленными правилами.\n" +
                "3.2 Пользуясь ботом, вы автоматически даете согласие на обработку персональных данных согласно Федеральному закону 'О персональных данных' от 27.07.2006 N 152-ФЗ.";

    }
}
