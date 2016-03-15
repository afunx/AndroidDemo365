// IMyAidlInterface.aidl
package com.afunx.aidlparcelableusage;

// Declare any non-default types here with import statements
import com.afunx.aidlparcelableusage.MyParcelable;

interface IMyAidlInterface {
    MyParcelable receiveParcelable();
    void postParcelable(in MyParcelable myParcelable);
}
