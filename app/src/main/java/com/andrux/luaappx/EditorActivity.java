package com.andrux.luaappx;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import io.github.rosemoe.sora.widget.CodeEditor;

public class EditorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CodeEditor editor = new CodeEditor(this);
        editor.setText("print('Hello Sora Editor')");
        setContentView(editor);
    }
}
