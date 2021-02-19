package bengalSofts.com.retrofit_real_api_get_method.model;

import java.util.List;

public class MainDataClass {

    private List<ObjectDataClass> data;

    public MainDataClass() {
    }

    public MainDataClass(List<ObjectDataClass> data) {
        this.data = data;
    }

    public List<ObjectDataClass> getData() {
        return data;
    }

    public void setData(List<ObjectDataClass> data) {
        this.data = data;
    }
}
