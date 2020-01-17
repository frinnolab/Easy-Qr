package dummyModels;

public class DataModel {
    private String name,code,address;

    public DataModel() {
        super();
    }

    public DataModel(String _name, String _code, String _address){
        this.name = _name;
        this.code = _code;
        this.address = _address;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
