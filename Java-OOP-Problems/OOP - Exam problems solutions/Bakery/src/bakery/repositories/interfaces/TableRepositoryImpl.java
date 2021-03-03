package bakery.repositories.interfaces;


import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TableRepositoryImpl implements TableRepository<Table>{

    private List<Table> models;

    public TableRepositoryImpl(){
        this.models = new ArrayList<>();
    }


    @Override
    public Collection<Table> getAll() {
        return Collections.unmodifiableList(models);
    }

    @Override
    public void add(Table table) {
        this.models.add(table);
    }

    @Override
    public Table getByNumber(int number) {
        Table table = null;
        for (Table table1 : models) {
            if(table1.getTableNumber() == number){
                table = table1;
            }
        }
        return table;
    }
}
