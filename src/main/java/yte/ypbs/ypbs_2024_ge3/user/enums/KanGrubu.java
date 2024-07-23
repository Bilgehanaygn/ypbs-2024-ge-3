package yte.ypbs.ypbs_2024_ge3.user.enums;

public enum KanGrubu {
    A_POZITIF("A+"),
    A_NEGATIF("A-"),
    B_POZITIF("B+"),
    B_NEGATIF("B-"),
    AB_POZITIF("AB+"),
    AB_NEGATIF("AB-"),
    O_POZITIF("O+"),
    O_NEGATIF("O-");

    private final String displayName;

    KanGrubu(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}


