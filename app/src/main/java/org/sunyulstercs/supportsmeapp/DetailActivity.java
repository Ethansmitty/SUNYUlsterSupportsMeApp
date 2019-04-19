package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Objects;

public class DetailActivity extends AppCompatActivity
{
    InfoItem info;
    ImageView departmentIcon;
    ImageView departmentBanner;
    TextView departmentLabelText;
    TextView departmentTitleText;
    TextView departmentDescText;
    TextView departmentPhoneText;
    TextView departmentEmailText;
    Button departmentWebsiteButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_detail);

        info = (InfoItem) Objects.requireNonNull(getIntent().getExtras()).get("InfoItem");

        departmentIcon = findViewById(R.id.department_icon);
        departmentBanner = findViewById(R.id.department_banner);
        departmentLabelText = findViewById(R.id.department_label_text);
        departmentTitleText = findViewById(R.id.department_title_text);
        departmentDescText = findViewById(R.id.department_desc_text);
        departmentPhoneText = findViewById(R.id.department_phone_text);
        departmentEmailText = findViewById(R.id.department_email_text);
        departmentWebsiteButton = findViewById(R.id.department_website_button);

        departmentWebsiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(info.getLink()); // missing 'http://' will cause crash
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                v.getContext().startActivity(intent);
            }
        });

        departmentTitleText.setText(info.getTitle());
        departmentLabelText.setText(info.getTitle());
        departmentDescText.setText(info.getDesc());

        departmentPhoneText.setText(info.getPhoneNumber());
        departmentPhoneText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(info.getFormattedPhoneNumber()));
                v.getContext().startActivity(intent);
            }
        });

        //TODO: Implement email addresses
        /*departmentEmailText.setText(info.getEmail());
        departmentEmailText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(info.getEmail()));
                v.getContext().startActivity(intent);
            }
        });*/

    }

}
