package me.whiteship.refactoring._11_primitive_obsession._30_repliace_primitive_with_object;

enum Priority {
    LOW,
    NORMAL,
    HIGH,
    RUSH;

    public boolean isImportantThan(Priority level) {
        return this.ordinal() > level.ordinal();
    }
}
