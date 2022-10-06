public class Contact {
    private String contactName;
    private String  mobileNumber;
    private String address;
    private String relationship;

    Contact(String contactName,String mobileNumber,String address,String relationship){
        this.contactName = contactName;
        this.mobileNumber = mobileNumber;
        this.address = address;
        this.relationship = relationship;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
