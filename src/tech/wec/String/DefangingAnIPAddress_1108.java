package tech.wec.String;

public class DefangingAnIPAddress_1108 {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.","[.]");
    }
}
