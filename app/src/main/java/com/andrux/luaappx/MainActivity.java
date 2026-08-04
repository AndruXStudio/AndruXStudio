package com.andrux.luaappx;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 这里只是为了确保通过编译，完整的布局代码需要你手动补充
        startActivity(new Intent(this, NewProjectActivity.class));
    }
}
