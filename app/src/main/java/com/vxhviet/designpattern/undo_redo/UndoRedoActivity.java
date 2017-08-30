package com.vxhviet.designpattern.undo_redo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.vxhviet.designpattern.R;
import com.vxhviet.designpattern.undo_redo.command.Command;
import com.vxhviet.designpattern.undo_redo.command.CommandExecutor;
import com.vxhviet.designpattern.undo_redo.command.DefaultCommandTarget;
import com.vxhviet.designpattern.undo_redo.command.UndoableSampleCommand;
import com.vxhviet.designpattern.undo_redo.memento.Caretaker;
import com.vxhviet.designpattern.undo_redo.memento.GenericMemento;
import com.vxhviet.designpattern.undo_redo.memento.Memento;
import com.vxhviet.designpattern.undo_redo.memento.Originator;

import java.util.ArrayList;


/**
 * Memento and Command pattern implementation for Undo/Redo function
 * References:
 *
 * http://codinginflipflops.com/post/48718235248/patterns-to-implement-undoredo-feature-part-1
 * http://codinginflipflops.com/post/48729281071/patterns-to-implement-undoredo-feature-part-2
 * http://www.journaldev.com/1734/memento-design-pattern-java
 */

public class UndoRedoActivity extends AppCompatActivity implements Originator {
    TextView mTextView;
    Button mUndoButton;
    Button mRedoButton;
    Button mDoButton;

    Button mButton1;
    Button mButton2;
    Button mButton3;
    Button mButton4;
    Button mButton5;
    Button mButton6;
    Button mButton7;
    Button mButton8;

    ArrayList<Button> mButtonList = new ArrayList<>();
    ArrayList<String> mStateList = new ArrayList<>();

    ListView mListView;

    String mState = "orig";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.textView);
        mUndoButton = (Button) findViewById(R.id.undo_button);
        mRedoButton = (Button) findViewById(R.id.redo_button);
        mDoButton = (Button) findViewById(R.id.do_button);
        mButton1 = (Button) findViewById(R.id.button1);
        mButton2 = (Button) findViewById(R.id.button2);
        mButton3 = (Button) findViewById(R.id.button3);
        mButton4 = (Button) findViewById(R.id.button4);
        mButton5 = (Button) findViewById(R.id.button5);
        mButton6 = (Button) findViewById(R.id.button6);
        mButton7 = (Button) findViewById(R.id.button7);
        mButton8 = (Button) findViewById(R.id.button8);

        mButtonList.add(mButton1);
        mButtonList.add(mButton2);
        mButtonList.add(mButton3);
        mButtonList.add(mButton4);
        mButtonList.add(mButton5);
        mButtonList.add(mButton6);
        mButtonList.add(mButton7);
        mButtonList.add(mButton8);

        mListView = (ListView) findViewById(R.id.listView);

        //testCommand();
        testMemento();
    }

    private void testCommand() {
        DefaultCommandTarget migration = new DefaultCommandTarget(0);
        final Command cmd = new UndoableSampleCommand(migration);
        final CommandExecutor exec = new CommandExecutor(5);

        mDoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exec.executeCommand(cmd);
            }
        });

        mUndoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exec.undoLastCommand();
            }
        });

        mRedoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exec.redoLastUndoedCommand();
            }
        });
    }

    private void testMemento() {
        final ArrayAdapter adapter = new ArrayAdapter(this, R.layout.item, mStateList);
        mListView.setAdapter(adapter);

        final Caretaker caretaker = new Caretaker();

        for (final Button b : mButtonList) {
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mState = (String) b.getText();
                    mTextView.setText(mState);

                    caretaker.save(UndoRedoActivity.this);

                    mStateList.clear();
                    for(int i = 0; i < caretaker.getList().size(); i++){
                        mStateList.add((String) ((Memento)caretaker.getList().get(i)).getState());
                    }
                    adapter.notifyDataSetChanged();
                }
            });
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                caretaker.restoreToState(UndoRedoActivity.this, i);
            }
        });
    }

    @Override
    public Memento saveToMemento() {
        return new GenericMemento<>(mState);
    }

    @Override
    public void restoreFromMemento(Memento memento) {
        mState = (String) memento.getState();
        Log.d("DEBUG_MEMENTO", "restoreFromMemento: mState: " + mState);
        mTextView.setText(mState);
    }

    @Override
    public Object getState() {
        return null;
    }
}
