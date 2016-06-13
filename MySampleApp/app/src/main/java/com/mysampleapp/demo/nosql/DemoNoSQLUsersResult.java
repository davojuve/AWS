package com.mysampleapp.demo.nosql;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.amazonaws.AmazonClientException;
import com.amazonaws.mobile.AWSMobileClient;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;

import java.util.Set;

public class DemoNoSQLUsersResult implements DemoNoSQLResult {
    private static final int KEY_TEXT_COLOR = 0xFF333333;
    private final UsersDO result;

    DemoNoSQLUsersResult(final UsersDO result) {
        this.result = result;
    }
    @Override
    public void updateItem() {
        final DynamoDBMapper mapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        final String originalValue = result.getEmail();
        result.setEmail(DemoSampleDataGenerator.getRandomSampleString("email"));
        try {
            mapper.save(result);
        } catch (final AmazonClientException ex) {
            // Restore original data if save fails, and re-throw.
            result.setEmail(originalValue);
            throw ex;
        }
    }

    @Override
    public void deleteItem() {
        final DynamoDBMapper mapper = AWSMobileClient.defaultMobileClient().getDynamoDBMapper();
        mapper.delete(result);
    }

    private void setKeyTextViewStyle(final TextView textView) {
        textView.setTextColor(KEY_TEXT_COLOR);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(dp(5), dp(2), dp(5), 0);
        textView.setLayoutParams(layoutParams);
    }

    /**
     * @param dp number of design pixels.
     * @return number of pixels corresponding to the desired design pixels.
     */
    private int dp(int dp) {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        return dp * (metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
    private void setValueTextViewStyle(final TextView textView) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        layoutParams.setMargins(dp(15), 0, dp(15), dp(2));
        textView.setLayoutParams(layoutParams);
    }

    private void setKeyAndValueTextViewStyles(final TextView keyTextView, final TextView valueTextView) {
        setKeyTextViewStyle(keyTextView);
        setValueTextViewStyle(valueTextView);
    }

    private static String bytesToHexString(byte[] bytes) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("%02X", bytes[0]));
        for(int index = 1; index < bytes.length; index++) {
            builder.append(String.format(" %02X", bytes[index]));
        }
        return builder.toString();
    }

    private static String byteSetsToHexStrings(Set<byte[]> bytesSet) {
        final StringBuilder builder = new StringBuilder();
        int index = 0;
        for (byte[] bytes : bytesSet) {
            builder.append(String.format("%d: ", ++index));
            builder.append(bytesToHexString(bytes));
            if (index < bytesSet.size()) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    @Override
    public View getView(final Context context, final View convertView, int position) {
        final LinearLayout layout;
        final TextView resultNumberTextView;
        final TextView userIdKeyTextView;
        final TextView userIdValueTextView;
        final TextView firstNameKeyTextView;
        final TextView firstNameValueTextView;
        final TextView emailKeyTextView;
        final TextView emailValueTextView;
        final TextView externalIdKeyTextView;
        final TextView externalIdValueTextView;
        final TextView externalProviderKeyTextView;
        final TextView externalProviderValueTextView;
        final TextView lastNameKeyTextView;
        final TextView lastNameValueTextView;
        if (convertView == null) {
            layout = new LinearLayout(context);
            layout.setOrientation(LinearLayout.VERTICAL);
            resultNumberTextView = new TextView(context);
            resultNumberTextView.setGravity(Gravity.CENTER_HORIZONTAL);
            layout.addView(resultNumberTextView);


            userIdKeyTextView = new TextView(context);
            userIdValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(userIdKeyTextView, userIdValueTextView);
            layout.addView(userIdKeyTextView);
            layout.addView(userIdValueTextView);

            firstNameKeyTextView = new TextView(context);
            firstNameValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(firstNameKeyTextView, firstNameValueTextView);
            layout.addView(firstNameKeyTextView);
            layout.addView(firstNameValueTextView);

            emailKeyTextView = new TextView(context);
            emailValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(emailKeyTextView, emailValueTextView);
            layout.addView(emailKeyTextView);
            layout.addView(emailValueTextView);

            externalIdKeyTextView = new TextView(context);
            externalIdValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(externalIdKeyTextView, externalIdValueTextView);
            layout.addView(externalIdKeyTextView);
            layout.addView(externalIdValueTextView);

            externalProviderKeyTextView = new TextView(context);
            externalProviderValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(externalProviderKeyTextView, externalProviderValueTextView);
            layout.addView(externalProviderKeyTextView);
            layout.addView(externalProviderValueTextView);

            lastNameKeyTextView = new TextView(context);
            lastNameValueTextView = new TextView(context);
            setKeyAndValueTextViewStyles(lastNameKeyTextView, lastNameValueTextView);
            layout.addView(lastNameKeyTextView);
            layout.addView(lastNameValueTextView);
        } else {
            layout = (LinearLayout) convertView;
            resultNumberTextView = (TextView) layout.getChildAt(0);

            userIdKeyTextView = (TextView) layout.getChildAt(1);
            userIdValueTextView = (TextView) layout.getChildAt(2);

            firstNameKeyTextView = (TextView) layout.getChildAt(3);
            firstNameValueTextView = (TextView) layout.getChildAt(4);

            emailKeyTextView = (TextView) layout.getChildAt(5);
            emailValueTextView = (TextView) layout.getChildAt(6);

            externalIdKeyTextView = (TextView) layout.getChildAt(7);
            externalIdValueTextView = (TextView) layout.getChildAt(8);

            externalProviderKeyTextView = (TextView) layout.getChildAt(9);
            externalProviderValueTextView = (TextView) layout.getChildAt(10);

            lastNameKeyTextView = (TextView) layout.getChildAt(11);
            lastNameValueTextView = (TextView) layout.getChildAt(12);
        }

        resultNumberTextView.setText(String.format("#%d", + position+1));
        userIdKeyTextView.setText("userId");
        userIdValueTextView.setText(result.getUserId());
        firstNameKeyTextView.setText("firstName");
        firstNameValueTextView.setText(result.getFirstName());
        emailKeyTextView.setText("email");
        emailValueTextView.setText(result.getEmail());
        externalIdKeyTextView.setText("externalId");
        externalIdValueTextView.setText(result.getExternalId());
        externalProviderKeyTextView.setText("externalProvider");
        externalProviderValueTextView.setText(result.getExternalProvider());
        lastNameKeyTextView.setText("lastName");
        lastNameValueTextView.setText(result.getLastName());
        return layout;
    }
}
