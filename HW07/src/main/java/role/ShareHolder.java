package role;
@SuppressWarnings("unused")
public class ShareHolder {
    private int id;
    private String name;
    private String phoneNumber;
    private String nationalCode;

    public ShareHolder() {
    }

    public ShareHolder( String name, String phoneNumber, String nationalCode) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.nationalCode = nationalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }
}
