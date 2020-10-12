package id.ac.ui.cs.mobileprogramming.jeremy.lab040;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Friend> selected = new MutableLiveData<>();

    public void setSelected(Friend friend) {
        selected.setValue(friend);
    }

    public MutableLiveData<Friend> getSelected() {
        return selected;
    }
}