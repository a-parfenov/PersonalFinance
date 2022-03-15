package personalfinance.settings;

import java.util.Calendar;
import java.util.HashMap;

final public class Text {
    
    private static final HashMap<String, String> data = new HashMap();
    
    public static String get(String key) {
        if (data.containsKey(key)) return data.get(key);
        System.out.println("Такого ключа в Text не существует!");
        return "";
    }
    
    public static String[] getMonths() {
        String[] months = new String[12];
        months[0] = get("JANUARY");
        months[1] = get("FEBRUARY");
        months[2] = get("MARCH");
        months[3] = get("APRIL");
        months[4] = get("MAY");
        months[5] = get("JUNE");
        months[6] = get("JULY");
        months[7] = get("AUGUST");
        months[8] = get("SEPTEMBER");
        months[9] = get("OCTOBER");
        months[10] = get("NOVEMBER");
        months[11] = get("DECEMBER");
        return months;
    }
    
    public static void init() {
        if (Settings.getLanguage().equals("ru")) {
            data.put("PROGRAM_NAME", "Домашняя бухгалтерия");

            data.put("JANUARY", "Январь");
            data.put("FEBRUARY", "Февраль");
            data.put("MARCH", "Март");
            data.put("APRIL", "Апрель");
            data.put("MAY", "Май");
            data.put("JUNE", "Июнь");
            data.put("JULY", "Июль");
            data.put("AUGUST", "Август");
            data.put("SEPTEMBER", "Сентябрь");
            data.put("OCTOBER", "Октябрь");
            data.put("NOVEMBER", "Ноябрь");
            data.put("DECEMBER", "Декабрь");

            data.put("ERROR", "Ошибка");
            data.put("ERROR_TITLE_EMPTY", "Вы не ввели название!");
            data.put("ERROR_IS_EXISTS", "Такая запись уже существует!");
            data.put("ERROR_DATE_FORMAT", "Некорректный формат даты!");
            data.put("ERROR_CODE_EMPTY", "Вы не указали код!");
            data.put("ERROR_CURRENCY_EMPTY", "Вы не выбрали валюту!");
            data.put("ERROR_ARTICLE_EMPTY", "Вы не выбрали статью!");
            data.put("ERROR_ACCOUNT_EMPTY", "Вы не выбрали счёт!");
            data.put("ERROR_RATE_INCORRECT", "Некорректное значение курса!");
            data.put("ERROR_AMOUNT_FORMAT", "Некорректный формат суммы!");
            data.put("ERROR_NO_BASE_CURRENCY", "Необходима базовая валюта! Установите сначала этот параметр в другой валюте, потом он снимется в этой автоматически.");
            data.put("ERROR_UPDATE_CURRENCIES", "Ошибка при обновлении курсов валют!");

            data.put("CONFIRM_EXIT_TEXT", "Вы действительно хотите выйти? Все несохранённые данные будут потеряны!");
            data.put("CONFIRM_EXIT_TITLE", "Подтверждение выхода");
            data.put("CONFIRM_DELETE_TEXT", "Вы уверены, что хотите удалить данную запись?");
            data.put("CONFIRM_DELETE_TITLE", "Подтверждение удаления");

            data.put("YES", "Да");
            data.put("NO", "Нет");

            data.put("MENU_FILE", "Файл");
            data.put("MENU_EDIT", "Правка");
            data.put("MENU_VIEW", "Вид");
            data.put("MENU_SETTINGS", "Настройки");
            data.put("MENU_HELP", "Помощь");

            data.put("MENU_FILE_NEW", "Новый");
            data.put("MENU_FILE_OPEN", "Открыть");
            data.put("MENU_FILE_SAVE", "Сохранить");
            data.put("MENU_FILE_UPDATE_CURRENCIES", "Обновить курс валют");
            data.put("MENU_FILE_EXIT", "Выход");

            data.put("MENU_EDIT_ADD", "Добавить");
            data.put("MENU_EDIT_EDIT", "Изменить");
            data.put("MENU_EDIT_DELETE", "Удалить");

            data.put("MENU_VIEW_OVERVIEW", "Обзор");
            data.put("MENU_VIEW_ACCOUNTS", "Счета");
            data.put("MENU_VIEW_ARTICLES", "Статьи");
            data.put("MENU_VIEW_TRANSACTIONS", "Транзакции");
            data.put("MENU_VIEW_TRANSFERS", "Переводы");
            data.put("MENU_VIEW_CURRENCIES", "Валюты");
            data.put("MENU_VIEW_STATISTICS", "Статистика");
            
            data.put("MENU_SETTINGS_LANGUAGE", "Язык");
            data.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Русский");
            data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "Английский");
            
            data.put("MENU_HELP_ABOUT", "О программе");

            data.put("TOOLBAR_OVERVIEW", "Обзор");
            data.put("TOOLBAR_ACCOUNTS", "Счета");
            data.put("TOOLBAR_ARTICLES", "Статьи");
            data.put("TOOLBAR_TRANSACTIONS", "Транзакции");
            data.put("TOOLBAR_TRANSFERS", "Переводы");
            data.put("TOOLBAR_CURRENCIES", "Валюты");
            data.put("TOOLBAR_STATISTICS", "Статистика");

            data.put("ADD", "Добавить");
            data.put("EDIT", "Изменить");
            data.put("DELETE", "Удалить");
            data.put("CANCEL", "Отмена");

            data.put("TODAY", "Сегодня");

            data.put("LABEL_TITLE", "Название:");
            data.put("LABEL_CURRENCY", "Валюта:");
            data.put("LABEL_START_AMOUNT", "Начальный баланс:");
            data.put("LABEL_DATE", "Дата:");
            data.put("LABEL_ACCOUNT", "Счёт:");
            data.put("LABEL_ARTICLE", "Статья:");
            data.put("LABEL_AMOUNT", "Сумма:");
            data.put("LABEL_NOTICE", "Примечание:");
            data.put("LABEL_FROM_ACCOUNT", "Откуда:");
            data.put("LABEL_TO_ACCOUNT", "Куда:");
            data.put("LABEL_FROM_AMOUNT", "Снято:");
            data.put("LABEL_TO_AMOUNT", "Зачислено:");
            data.put("LABEL_CODE", "Код:");
            data.put("LABEL_RATE", "Курс:");
            data.put("LABEL_ON", "Включено:");
            data.put("LABEL_BASE", "Базовая:");

            data.put("BALANCE_CURRENCIES", "Баланс по валютам");
            data.put("BALANCE", "Итоговый баланс");

            data.put("FC_HOME", "Домашняя директория");
            data.put("FC_OPEN", "Открыть");
            data.put("FC_SAVE", "Сохранить");
            data.put("FC_CANCEL", "Отмена");
            data.put("FC_LOOK", "Папка:");
            data.put("FC_NAME_FILE", "Имя файла:");
            data.put("FC_TYPE_FILE", "Тип файла:");
            data.put("FC_UP", "Вверх");
            data.put("FC_NEW_DIRECTORY", "Новая папка");
            data.put("FC_LIST", "Список");
            data.put("FC_TABLE", "Таблица");
            data.put("FC_NAME", "Имя");
            data.put("FC_SIZE", "Размер");
            data.put("FC_TYPE", "Тип");
            data.put("FC_DATE", "Дата");
            data.put("FC_ATTR", "Атрибуты");
            data.put("FC_ALL_FILTER", "Все файлы");

            data.put("LAST_TRANSACTIONS", "Последние транзакции");
            data.put("ACCOUNTS", "Счета");
            data.put("ARTICLES", "Статьи");
            data.put("TRANSACTIONS", "Транзакции");
            data.put("TRANSFERS", "Переводы");
            data.put("CURRENCIES", "Валюты");
            data.put("STATISTICS", "Статистика");

            data.put("TITLE", "Название");
            data.put("DATE", "Дата");
            data.put("ACCOUNT", "Счёт");
            data.put("ARTICLE", "Статья");
            data.put("AMOUNT", "Сумма");
            data.put("NOTICE", "Примечание");
            data.put("FROM_ACCOUNT", "Откуда");
            data.put("TO_ACCOUNT", "Куда");
            data.put("FROM_AMOUNT", "Снято");
            data.put("TO_AMOUNT", "Зачислено");
            data.put("CODE", "Код");
            data.put("RATE", "Курс");
            data.put("ON", "Включено");
            data.put("BASE", "Базовая");

            data.put("CHART_INCOME", "Доходы по статьям");
            data.put("CHART_EXP", "Расходы по статьям");
            data.put("CHART_NO_DATA", "Нет данных за выбранный период!");

            data.put("DIALOG_ABOUT_TITLE", "О программе");
            data.put("ABOUT", "<body style='font-size: 120%; text-align: center; width: 500px;'>"
                    + "<h1>Домашняя бухгалтерия</h1><p><img src='file:images/main.png' /></p>"
                    + "<p>Данная программа была сделана в целях обучения"
                    + "<p>По вопросам обращаться: <a style='font-weight: bold;' href='mailto:a.parfenov.job@gmail.com'>a.parfenov.job@gmail.com</a></p>"
                    + "<p>С Уважением, Парфенов Антон!</p>"
                    + "<p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " "
                    + "<p></p>"
                    + " \"<p> </p>\"</p></body>");
        }
        else {
            data.put("PROGRAM_NAME", "Personal Finance");

            data.put("JANUARY", "January");
            data.put("FEBRUARY", "February");
            data.put("MARCH", "March");
            data.put("APRIL", "April");
            data.put("MAY", "May");
            data.put("JUNE", "June");
            data.put("JULY", "July");
            data.put("AUGUST", "August");
            data.put("SEPTEMBER", "September");
            data.put("OCTOBER", "October");
            data.put("NOVEMBER", "November");
            data.put("DECEMBER", "December");
            
            data.put("ERROR", "Error");
            data.put("ERROR_TITLE_EMPTY", "You have not entered a name!");
            data.put("ERROR_IS_EXISTS", "This entry already exists!");
            data.put("ERROR_DATE_FORMAT", "Invalid date format!");
            data.put("ERROR_CODE_EMPTY", "Вы не указали код!");
            data.put("ERROR_CURRENCY_EMPTY", "You did not specify the currency!");
            data.put("ERROR_ARTICLE_EMPTY", "You did not specify an article!");
            data.put("ERROR_ACCOUNT_EMPTY", "You did not specify an account!");
            data.put("ERROR_RATE_INCORRECT", "Invalid rate value!");
            data.put("ERROR_AMOUNT_FORMAT", "Invalid amount format!");
            data.put("ERROR_NO_BASE_CURRENCY", "Base currency required! First set this parameter in another currency, then it will be removed in this automatically.");
            data.put("ERROR_UPDATE_CURRENCIES", "Error updating currencies!");

            data.put("CONFIRM_EXIT_TEXT", "Do you really want to exit? All unsaved data will be lost!");
            data.put("CONFIRM_EXIT_TITLE", "Exit confirmation");
            data.put("CONFIRM_DELETE_TEXT", "Are you sure you want to delete this entry?");
            data.put("CONFIRM_DELETE_TITLE", "Confirm");

            data.put("YES", "Yes");
            data.put("NO", "No");

            data.put("MENU_FILE", "File");
            data.put("MENU_EDIT", "Edit");
            data.put("MENU_VIEW", "View");
            data.put("MENU_SETTINGS", "Settings");
            data.put("MENU_HELP", "Help");

            data.put("MENU_FILE_NEW", "New");
            data.put("MENU_FILE_OPEN", "Open");
            data.put("MENU_FILE_SAVE", "Save");
            data.put("MENU_FILE_UPDATE_CURRENCIES", "Update currencies");
            data.put("MENU_FILE_EXIT", "Exit");

            data.put("MENU_EDIT_ADD", "Add");
            data.put("MENU_EDIT_EDIT", "Edit");
            data.put("MENU_EDIT_DELETE", "Delete");

            data.put("MENU_VIEW_OVERVIEW", "Overview");
            data.put("MENU_VIEW_ACCOUNTS", "Accounts");
            data.put("MENU_VIEW_ARTICLES", "Articles");
            data.put("MENU_VIEW_TRANSACTIONS", "Transactions");
            data.put("MENU_VIEW_TRANSFERS", "Transfers");
            data.put("MENU_VIEW_CURRENCIES", "Currencies");
            data.put("MENU_VIEW_STATISTICS", "Statistics");
            
            data.put("MENU_SETTINGS_LANGUAGE", "Language");
            data.put("MENU_SETTINGS_LANGUAGE_RUSSIAN", "Russian");
            data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "English");
            
            data.put("MENU_HELP_ABOUT", "About");
            
            data.put("TOOLBAR_OVERVIEW", "Overview");
            data.put("TOOLBAR_ACCOUNTS", "Accounts");
            data.put("TOOLBAR_ARTICLES", "Articles");
            data.put("TOOLBAR_TRANSACTIONS", "Transactions");
            data.put("TOOLBAR_TRANSFERS", "Transfers");
            data.put("TOOLBAR_CURRENCIES", "Currencies");
            data.put("TOOLBAR_STATISTICS", "Statistics");

            data.put("ADD", "Add");
            data.put("EDIT", "Edit");
            data.put("DELETE", "Delete");
            data.put("CANCEL", "Cancel");

            data.put("TODAY", "Today");

            data.put("LABEL_TITLE", "Title:");
            data.put("LABEL_CURRENCY", "Currency:");
            data.put("LABEL_START_AMOUNT", "Start amount:");
            data.put("LABEL_DATE", "Date:");
            data.put("LABEL_ACCOUNT", "Account:");
            data.put("LABEL_ARTICLE", "Article:");
            data.put("LABEL_AMOUNT", "Amount:");
            data.put("LABEL_NOTICE", "Notice:");
            data.put("LABEL_FROM_ACCOUNT", "From:");
            data.put("LABEL_TO_ACCOUNT", "To:");
            data.put("LABEL_FROM_AMOUNT", "Withdrawn:");
            data.put("LABEL_TO_AMOUNT", "Credited:");
            data.put("LABEL_CODE", "Code:");
            data.put("LABEL_RATE", "Rate:");
            data.put("LABEL_ON", "Enable:");
            data.put("LABEL_BASE", "Basic:");

            data.put("BALANCE_CURRENCIES", "Balance by currencies");
            data.put("BALANCE", "Total balance");

            data.put("FC_HOME", "Home");
            data.put("FC_OPEN", "Open");
            data.put("FC_SAVE", "Save");
            data.put("FC_CANCEL", "Cancel");
            data.put("FC_LOOK", "Folder:");
            data.put("FC_NAME_FILE", "File name:");
            data.put("FC_TYPE_FILE", "File type:");
            data.put("FC_UP", "Up");
            data.put("FC_NEW_DIRECTORY", "New folder");
            data.put("FC_LIST", "List");
            data.put("FC_TABLE", "Table");
            data.put("FC_NAME", "Name");
            data.put("FC_SIZE", "Size");
            data.put("FC_TYPE", "Type");
            data.put("FC_DATE", "Date");
            data.put("FC_ATTR", "Attributes");
            data.put("FC_ALL_FILTER", "All files");

            data.put("LAST_TRANSACTIONS", "Last transactions");
            data.put("ACCOUNTS", "Accounts");
            data.put("ARTICLES", "Articles");
            data.put("CURRENCIES", "Currencies");
            data.put("TRANSACTIONS", "Transactions");
            data.put("TRANSFERS", "Transfers");
            data.put("STATISTICS", "Statistics");

            data.put("TITLE", "Title");
            data.put("DATE", "Date");
            data.put("ACCOUNT", "Account");
            data.put("ARTICLE", "Article");
            data.put("AMOUNT", "Amount");
            data.put("NOTICE", "Notice");
            data.put("FROM_ACCOUNT", "From");
            data.put("TO_ACCOUNT", "To");
            data.put("FROM_AMOUNT", "Withdrawn");
            data.put("TO_AMOUNT", "Credited");
            data.put("CODE", "Code");
            data.put("RATE", "Rate");
            data.put("ON", "Enable");
            data.put("BASE", "Basic");

            data.put("CHART_INCOME", "Incomes by articles");
            data.put("CHART_EXP", "Expenses by articles");
            data.put("CHART_NO_DATA", "No data for the selected period!");

            data.put("DIALOG_ABOUT_TITLE", "About");
            data.put("ABOUT", "<body style='font-size: 120%; text-align: center; width: 500px;'>"
                    + "<h1>Home accounting</h1><p><img src='file:images/main.png' /></p>"
                    + "<p>This program was made for the purpose of training"
                    + "<p>For questions, please contact: <a style='font-weight: bold;' href='mailto:a.parfenov.job@gmail.com'>a.parfenov.job@gmail.com</a></p>"
                    + "<p>Sincerely, Anton Parfenov!</p>"
                    + "<p>Copyright " + Calendar.getInstance().get(Calendar.YEAR) + " "
                    + "<p></p>"
                    + " \"<p> </p>\"</p></body>");
        }
    }
}
