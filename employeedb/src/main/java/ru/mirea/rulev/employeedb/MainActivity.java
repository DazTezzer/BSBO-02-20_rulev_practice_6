package ru.mirea.rulev.employeedb;


import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import ru.mirea.rulev.employeedb.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppDatabase db = App.getInstance().getDatabase();
        EmployeeDao employeeDao = db.employeeDao();

        Employee employee = new Employee();
        employee.name = "John Smith";
        employee.salary = 10000;

// запись сотрудников в базу
        employeeDao.insert(employee);

// Загрузка всех работников
        List<Employee> employees = employeeDao.getAll();

// Получение определенного работника с id = 1
        employee = employeeDao.getById(1);

// Обновление полей объекта
        employee.salary = 20000;
        employeeDao.update(employee);
        Log.d(TAG, employee.name + " " + employee.salary);
    }
}
