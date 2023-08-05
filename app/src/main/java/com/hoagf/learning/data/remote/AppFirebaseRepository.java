package com.hoagf.learning.data.remote;

import static com.hoagf.learning.utils.Constants.TOTAL_NUMBER_OF_APP_OPENINGS;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.hoagf.learning.utils.Constants;

import javax.inject.Inject;

public class AppFirebaseRepository implements FirebaseRepository{
    private DatabaseReference reference;

    @Inject
    public AppFirebaseRepository(DatabaseReference reference) {
        this.reference = reference;
    }

    @Override
    public void incrementTotalNumberOfAppOpenings() {
        reference.child(TOTAL_NUMBER_OF_APP_OPENINGS).runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                if (currentData.getValue() == null) {
                    currentData.setValue(1);
                } else {
                    currentData.setValue((Long) currentData.getValue() + 1);
                }
                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
            }
        });
    }

    @Override
    public MutableLiveData<DataSnapshot> getLessonData() {
        MutableLiveData<DataSnapshot> liveData = new MutableLiveData<>();
        reference.child(Constants.DATA).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                liveData.setValue(snapshot);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
        return liveData;
    }
}
