package ChatSystemMVVMSockets.client.views.userlist;

import ChatSystemMVVMSockets.shared.transferobjects.UserEntry;
import ChatSystemMVVMSockets.client.viewmodel.UserlistViewModel;
import ChatSystemMVVMSockets.client.viewmodel.ViewModelFactory;
import ChatSystemMVVMSockets.client.views.ViewController;
import ChatSystemMVVMSockets.client.views.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserlistViewController implements ViewController
{

    // I can make these field public. Or make them private, and mark them with @FXML.
    // The result is the same. Private is probably preferable,
    // because if something doesn't _need_ to be public, it shouldn't be

    @FXML
    private TableView<UserEntry> tableView;
    public TableColumn<String, UserEntry> inputColumn;

    private UserlistViewModel vm;
    private ViewHandler vh;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.vh = vh;
        vm = vmf.getUserlistViewModel();
        vm.loadUsers();
        tableView.setItems(vm.getUsers());
        inputColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
    }

    public void exit() {
        vh.openLogin();
    }

    public void enterChat() { vh.openChatWindow(); }
}
