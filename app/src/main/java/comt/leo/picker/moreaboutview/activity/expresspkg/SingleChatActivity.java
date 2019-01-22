package comt.leo.picker.moreaboutview.activity.expresspkg;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import comt.leo.picker.moreaboutview.R;

/**
 * Created by leo
 * on 2019/1/15.
 */
public class SingleChatActivity extends AppCompatActivity {
    private RecyclerView rvSingleChat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlechat);
        rvSingleChat = findViewById(R.id.rvSingleChat);

    }
}
