package ru.netology.web.page;

import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id=amount] input");
    private SelenideElement fromField = $("[data-test-id=from] input");
    private SelenideElement transferButton = $("[data-test-id=action-transfer]");

    public DashboardPage transferMoney(int amount, DataHelper.CardInfo from) {
        amountField.setValue(valueOf(amount));
        fromField.setValue(valueOf(from));
        transferButton.click();
        return new DashboardPage();
    }

    public void getLimitExceededError() {
        $(byText("Ошибка! Сумма перевода превышает допустимый лимит!")).shouldBe(visible);
    }

    public void getErrorInvalidCard() {
        $(byText("Ошибка! Номер карты для зачисления совпадает с номером карты для списания!")).shouldBe(visible);
    }
}
