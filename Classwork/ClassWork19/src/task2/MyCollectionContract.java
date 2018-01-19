package task2;

public interface MyCollectionContract<Department, Staff> {

    //функционал для директора
    void setDirector(Staff director);
    Staff getDirector();
    void removeDirector();

    //функционал для отделов
    void addDepartment(Department department);
    void  removeDepartment(Department department);


    //функционал для сотрудников
    void addStaff(Staff staff, Department department);
    void removeStaff(Staff staff, Department department);
    void moveStaff(Staff staff, Department departmentOut, Department departmentIn);






}
