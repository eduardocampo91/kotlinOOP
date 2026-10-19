package Corporation

enum class OperationCode(val title: String) {
    EXIT(title = "Exit"),
    REGISTER_NEW_ITEM(title = "Register new item"),
    SHOW_ALL_ITEMS(title = "Show all items"),
    REMOVE_PRODUCT_CARD(title = "Removing product from card"),
    REGISTER_NEW_EMPLOYEE(title= "Register new employee"),
    FIRE_EMPLOYEE(title= "Fire employee"),
    SHOW_ALL_EMPLOYEES(title= "Show all employees"),
}