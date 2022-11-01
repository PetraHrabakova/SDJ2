package ChatSystemMVVMLocal.viewmodel;

import ChatSystemMVVMLocal.model.ModelFactory;

public class ViewModelFactory {

    private final ModelFactory mf;
    private LoginViewModel loginViewModel;
    private UserlistViewModel userlistViewModel;
    private ChatWindowViewModel chatWindowViewModel;

    public ViewModelFactory(ModelFactory mf) {
        this.mf = mf;
    }

    public LoginViewModel getLoginViewModel() {
        if (loginViewModel == null)
            loginViewModel = new LoginViewModel(mf.getDataModel());
        return loginViewModel;
    }

    public UserlistViewModel getUserlistViewModel() {
        return (userlistViewModel = userlistViewModel == null ?
                new UserlistViewModel(mf.getDataModel()) :
                userlistViewModel);
    }

    public ChatWindowViewModel getChatWindowViewModel() {
        return (chatWindowViewModel = chatWindowViewModel == null ?
            new ChatWindowViewModel(mf.getDataModel()) :
            chatWindowViewModel);
    }

}
