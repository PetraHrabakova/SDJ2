package HeaterSystem.viewmodel;

import HeaterSystem.model.ModelFactory;

public class ViewModelFactory {

    private HeaterSystemViewModel heaterViewModel;

    public ViewModelFactory(ModelFactory modelFactory) {
        heaterViewModel = new HeaterSystemViewModel(modelFactory.getDataModel());
    }

    public HeaterSystemViewModel getHeaterViewModel() {
        return heaterViewModel;
    }
}
