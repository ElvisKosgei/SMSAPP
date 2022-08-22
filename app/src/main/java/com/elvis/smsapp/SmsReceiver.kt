package com.elvis.smsapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log
import android.widget.Toast

class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (!intent.action.equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
            return
        }
        val smsMessages = Telephony.Sms.Intents.getMessagesFromIntent(intent)
        smsMessages.forEach {
            val sms = it.displayMessageBody
            val sender = it.displayOriginatingAddress
            Toast.makeText(context, "$sender : $sms", Toast.LENGTH_LONG).show()
            Log.d("MESSAGE_RECEIVED", sms)
            Log.d("MESSAGE_RECEIVED", sender)

           //Toast.makeText(this, "${it.displayMessageBody} ${it.displayOriginatingAddress}", Toast.LENGTH_SHORT)
            if(sender.equals("0723456732") || sms.contains("dear")){

            }
        }

    }
}