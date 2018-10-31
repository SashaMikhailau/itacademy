package theme4_classes_and_objects.task25.financeElements.cards;

import utils.ConsoleHelper;
/*Вип сервис- наследуют этот интерфейс элитные карточки*/
public interface VipService {
    default void callToConsiergeService(){
        ConsoleHelper.writeToConsole("Calling to consierge");
    };
}
