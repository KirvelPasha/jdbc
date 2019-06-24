package menu;

public class UserFabric {
    private Menu menu;

    public Menu getMenu(Role role){
        switch (role){
            case ADMIN:
                menu = new AdminMenu();
                break;
            case CLIENT:
                menu = new ClientMenu();
                break;
            case VISITOR:
                menu = new VisitorMenu();
                break;
            default:
                System.out.println("Sorry. Unknown role");
                break;
        }
        return menu;
    }
}
