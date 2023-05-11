package git.shin.plugins.pip;

import android.util.Log;
import android.app.PictureInPictureParams;
import android.util.Rational;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.res.Configuration;
import android.os.Build;
import android.util.Rational;

public class PiP {
    private Activity activity;
    private OnPipModeChangedListener onPipModeChangedListener;

    public PiP(Activity activity) {
        this.activity = activity;
    }

    public void enterPip(float width, float height) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Rational aspectRatio = new Rational((int) (width * 100), (int) (height * 100));
            PictureInPictureParams params = new PictureInPictureParams.Builder()
                    .setAspectRatio(aspectRatio)
                    .build();
            activity.enterPictureInPictureMode(params);
        }
    }

    public boolean isPipSupported() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O;
    }

    public void setOnPipModeChangedListener(OnPipModeChangedListener listener) {
        this.onPipModeChangedListener = listener;
    }

    public void onConfigurationChanged(Configuration newConfig) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (onPipModeChangedListener != null) {
                boolean isInPipMode = activity.isInPictureInPictureMode();
                onPipModeChangedListener.onPipModeChanged(isInPipMode);
            }
        }
    }

    public interface OnPipModeChangedListener {
        void onPipModeChanged(boolean isInPipMode);
    }
}