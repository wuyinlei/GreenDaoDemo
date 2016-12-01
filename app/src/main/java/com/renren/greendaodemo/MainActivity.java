package com.renren.greendaodemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.renren.greendaodemo.bean.greendao.StudentDao;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mActivityMain;
    private Button mBtnAdd;
    private Button mBtnDelete;
    private Button mBtnUpdate;
    private Button mBtnSelect;
    private TextView mTvResult;

    private StudentDao mStudentDao;
    private List<Student> mStudents;
    private Student mStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initListener() {
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);
        mBtnUpdate.setOnClickListener(this);
        mBtnSelect.setOnClickListener(this);
    }

    private void initView() {
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
        mBtnAdd = (Button) findViewById(R.id.btn_add);
        mBtnDelete = (Button) findViewById(R.id.btn_delete);
        mBtnUpdate = (Button) findViewById(R.id.btn_update);
        mBtnSelect = (Button) findViewById(R.id.btn_select);
        mTvResult = (TextView) findViewById(R.id.tv_result);

        mStudentDao = DaoApplication.getmInstance().getDaoSession().getStudentDao();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_add:
                insertData();
                break;
            case R.id.btn_delete:
                deleteData();
                break;
            case R.id.btn_update:
                updateData();
                break;
            case R.id.btn_select:
                selectData();
                break;
        }
    }

    private void selectData() {
        List<Student> students = mStudentDao.loadAll();
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < students.size(); i++) {
            buffer.append("\r\n");
            buffer.append(students.get(i).toString());
        }
        mTvResult.setText(buffer);

    }

    private void updateData() {
        Student student = new Student();
        student.setName("Tome");
        student.setAge("20");
        student.setId(1000L);
        student.setScore("120");
        student.setAddress("tiananmen");
        mStudentDao.update(student);

        mTvResult.setText(student.toString());
    }

    private void deleteData() {
        mStudentDao.deleteByKey(1000L);
        Toast.makeText(this, "delete success", Toast.LENGTH_SHORT).show();
    }

    private int index = 2;

    private void insertData() {

        if (index == 1) {  //在这只是一个模拟，但是有局限性，比如杀死app在次进入，就会走这个流程，
            //但是数据库中已经有了一个id了，而且这个id是唯一主键，那么这个时候就会报
            // UNIQUE constraint failed: STUDENT._id 这个错误
            //当然在实际的开发过程中不会这样走逻辑的，根据具体的开发流程写自己的增删改查逻辑
            //这里只是用于演示。

            index++;
            Student student = new Student();
            student.setName("Tom");
            student.setAge("10");
            student.setId(1000L);
            student.setScore("100");
            student.setAddress("beijing");
            long insert = mStudentDao.insert(student);
            if (insert != -1) {
                Toast.makeText(this, "insert success", Toast.LENGTH_SHORT).show();
            }
        } else {
            Student student = new Student();
            Random random = new Random();
            int count = random.nextInt(100);
            student.setName("Tom" + count);
            student.setAge(10 + count + "");
            student.setId(1000L + count);
            student.setScore(100 + count * 10 + "");
            student.setAddress("nanjing" + count);
            long insert = mStudentDao.insert(student);
            if (insert != -1) {
                Toast.makeText(this, "insert success", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
