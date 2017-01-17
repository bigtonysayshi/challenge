package self;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three",
 * it is the fifth second-level revision of the second first-level revision.
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        Integer major1, major2;
        String rest1 = null, rest2 = null;
        int dotPos1 = version1.indexOf('.');
        if (dotPos1 == -1) {
            major1 = Integer.valueOf(version1);
        } else {
            major1 = Integer.valueOf(version1.substring(0, dotPos1));
            rest1 = version1.substring(dotPos1+1);
        }
        int dotPos2 = version2.indexOf('.');
        if (dotPos2 == -1) {
            major2 = Integer.valueOf(version2);
        } else {
            major2 = Integer.valueOf(version2.substring(0, dotPos2));
            rest2 = version2.substring(dotPos2+1);
        }

        if (!major1.equals(major2)) {
            return major1.compareTo(major2);
        }

        if (rest1 == null && rest2 == null) {
            return 0;
        } else if (rest1 == null) {
            return compareVersion("0", rest2);
        } else if (rest2 == null) {
            return compareVersion(rest1, "0");
        } else {
            return compareVersion(rest1, rest2);
        }
    }

    public static void main(String[] args){
        CompareVersionNumbers instance = new CompareVersionNumbers();
        System.out.println(instance.compareVersion("1","3"));
        System.out.println(instance.compareVersion("1.1","1.3"));
        System.out.println(instance.compareVersion("1.5","1.31"));
        System.out.println(instance.compareVersion("3.5","2"));
        System.out.println(instance.compareVersion("3.5","12"));
        System.out.println(instance.compareVersion("0.1","0.0.1"));
        System.out.println(instance.compareVersion("1.0","1.0.0.1"));
        System.out.println(instance.compareVersion("1.0","1.0.0.0"));

    }
}
