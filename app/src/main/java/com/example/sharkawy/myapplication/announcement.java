package com.example.sharkawy.myapplication;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class announcement {

    //Instance of Firebasedatabase
    final private FirebaseDatabase database = FirebaseDatabase.getInstance();
//Instance of our actual database
private DatabaseReference mDatabaseReference;

    //Our announcements list
    private List<announcment> mAnnouncements;
    public void retrieveData() {
        //Gets the reference from the firebase database.
        mDatabaseReference = database.getReference();

        //queries specific location on database, in this case the child of the root (project) node
        //is Announcements, so we want that information.
        Query query = mDatabaseReference.child("Announcements");

        //In order to listen for changes, we will add a listener.
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            //Returns a new "dataSnapshot" of how the data in the database looks.
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //For every single snapshot in our data snapshot, we will get their children - these will
                //be the "announcement1" and "announcement2".
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    //Here, we use our model to create an object of the singleSnapshot.
                    announcment announcement = singleSnapshot.getValue(announcment.class);
                    //Adds this onto the list we have in this class.
                    mAnnouncements.add(announcement);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Do Nothing
            }
        });
    }
}


