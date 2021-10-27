import java.util.ArrayList;

public class validIPAddress {
    // O(1) time 0(1) space
    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> ipAddressFound = new ArrayList<String>();

        for (int i = 1; i < Math.min((int) string.length(), 4); i++) {
            String[] currentIpAddressParts = new String[] { "", "", "", "" };

            currentIpAddressParts[0] = string.substring(0, i);
            if (!isValidPart(currentIpAddressParts[0])) {
                continue;
            }

            for (int j = i + 1; j < i + Math.min((int) string.length() - i, 4); j++) {
                currentIpAddressParts[1] = string.substring(i, j);
                if (!isValidPart(currentIpAddressParts[1])) {
                    continue;
                }

                for (int k = j + 1; k < j + Math.min((int) string.length() - j, 4); k++) {
                    currentIpAddressParts[2] = string.substring(j, k);
                    currentIpAddressParts[3] = string.substring(k);

                    if (isValidPart(currentIpAddressParts[2]) && isValidPart(currentIpAddressParts[3])) {
                        ipAddressFound.add(join(currentIpAddressParts));
                    }
                }
            }
        }
        return ipAddressFound;
    }

    public boolean isValidPart(String string) {
        int stringAsInt = Integer.parseInt(string);
        if (stringAsInt > 255) {
            return false;
        }
        return string.length() == Integer.toString(stringAsInt).length();
    }

    public String join(String[] strings) {
        StringBuilder string = new StringBuilder();
        for (int letter = 0; letter < strings.length; letter++) {
            string.append(strings[1]);
            if (letter < strings.length - 1) {
                string.append(".");
            }
        }
        return string.toString();
    }

}
