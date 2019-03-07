package org.sunyulstercs.supportsmeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);
    }

    private String[][] make2DArray(String[]... arrays)
    {
        return arrays;
    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this, InfoActivity.class);

        switch(view.getId())
        {
            case R.id.campusResourceButton :

                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.srMapList),
                        getResources().getStringArray(R.array.kcMapList),
                        getResources().getStringArray(R.array.childcareList),
                        getResources().getStringArray(R.array.diningList),
                        getResources().getStringArray(R.array.bookstoreList),
                        getResources().getStringArray(R.array.counselingList),
                        getResources().getStringArray(R.array.freshStartList),
                        getResources().getStringArray(R.array.safeSpaceList),
                        getResources().getStringArray(R.array.foodPantryList),
                        getResources().getStringArray(R.array.tutorList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.resourcesList));
                intent.putExtra("ActivityName", getResources().getString(R.string.campusResourcesButtonDesc));
                break;

            case R.id.financialButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.givingList),
                        getResources().getStringArray(R.array.financialAidList),
                        getResources().getStringArray(R.array.scholarshipList),
                        getResources().getStringArray(R.array.studentAccountsList),
                        getResources().getStringArray(R.array.paymentPlanList),
                        getResources().getStringArray(R.array.eopList),
                        getResources().getStringArray(R.array.costCalcList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.financialList));
                intent.putExtra("ActivityName", getResources().getString(R.string.financialButtonDesc));
                break;

            case R.id.socialMediaButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.artSiteList),
                        getResources().getStringArray(R.array.athleticsList),
                        getResources().getStringArray(R.array.facebookList),
                        getResources().getStringArray(R.array.instagramList),
                        getResources().getStringArray(R.array.twitterList),
                        getResources().getStringArray(R.array.linkedinList),
                        getResources().getStringArray(R.array.snapchatList),
                        getResources().getStringArray(R.array.youtubeList),
                        getResources().getStringArray(R.array.blogList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.socialList));
                intent.putExtra("ActivityName", getResources().getString(R.string.socialMediaButtonDesc));
                break;

            case R.id.campusLifeButton:
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.athleticsList),
                        getResources().getStringArray(R.array.clubsList),
                        getResources().getStringArray(R.array.studentGovList),
                        getResources().getStringArray(R.array.eventCalendarList),
                        getResources().getStringArray(R.array.honorsList),
                        getResources().getStringArray(R.array.coilList),
                        getResources().getStringArray(R.array.diversityList),
                        getResources().getStringArray(R.array.weeklyCampusList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.campusLifeList));
                intent.putExtra("ActivityName", getResources().getString(R.string.campusLifeButtonDesc));
                break;

            case R.id.officesButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.nurseList),
                        getResources().getStringArray(R.array.disabilityList),
                        getResources().getStringArray(R.array.trioList),
                        getResources().getStringArray(R.array.publicSafetyList),
                        getResources().getStringArray(R.array.careerList),
                        getResources().getStringArray(R.array.learningList),
                        getResources().getStringArray(R.array.openLabsList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.officesList));
                intent.putExtra("ActivityName", getResources().getString(R.string.officesButtonDesc));
                break;

            case R.id.libraryButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.loanedBooksList),
                        getResources().getStringArray(R.array.hoursList),
                        getResources().getStringArray(R.array.reserveRoomList),
                        getResources().getStringArray(R.array.librarianList),
                        getResources().getStringArray(R.array.interlibraryList),
                        getResources().getStringArray(R.array.buildingHistoryList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.libraryList));
                intent.putExtra("ActivityName", getResources().getString(R.string.libraryButtonDesc));
                break;

            case R.id.studentLifeButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.advisorList),
                        getResources().getStringArray(R.array.calendarList),
                        getResources().getStringArray(R.array.handbookList),
                        getResources().getStringArray(R.array.campusNewsList),
                        getResources().getStringArray(R.array.majorList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.studentLifeList));
                intent.putExtra("ActivityName", getResources().getString(R.string.studentLifeButtonDesc));
                break;

            case R.id.scheduleButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.catalogList),
                        getResources().getStringArray(R.array.testingCalendarList),
                        getResources().getStringArray(R.array.scheduleList),
                        getResources().getStringArray(R.array.internshipsList),
                        getResources().getStringArray(R.array.transcriptsList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.scheduleInfoList));
                intent.putExtra("ActivityName", getResources().getString(R.string.scheduleButtonDesc));
                break;

            case R.id.transportationButton :
                intent.putExtra("CategoryData", make2DArray(
                        getResources().getStringArray(R.array.parkingMapList),
                        getResources().getStringArray(R.array.busScheduleList),
                        getResources().getStringArray(R.array.kcsuDirectionsList)
                ));
                intent.putExtra("ListItems", getResources().getStringArray(R.array.transportList));
                intent.putExtra("ActivityName", getResources().getString(R.string.transportationButtonDesc));
                break;
        }
        Log.d(view.toString(), "Starting activity...");
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //If activity is in the stack somewhere, reuse it.
        startActivity(intent);
    }
}
