package task2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyCollection<Department, Staff> implements MyCollectionContract<Department, Staff>{

    private Staff director;

    private HashMap<Department, List<Staff>> hashMap = new HashMap<>();


    @Override
    public void setDirector(Staff director) {
        this.director = director;

    }

    @Override
    public Staff getDirector() {
        return director;
    }

    @Override
    public void removeDirector() {
        director=null;

    }

    @Override
    public void addDepartment(Department department) {
        hashMap.put(department, new ArrayList<Staff>());

    }

    @Override
    public void removeDepartment(Department department) {
        hashMap.remove(department);

    }

    @Override
    public void addStaff(Staff staff, Department department) {
        hashMap.get(department).add(staff);

    }

    @Override
    public void removeStaff(Staff staff, Department department) {
        hashMap.get(department).remove(staff);

    }

    @Override
    public void moveStaff(Staff staff, Department departmentOut, Department departmentIn) {
        removeStaff(staff,departmentOut);
        addStaff(staff,departmentIn);

    }
}
