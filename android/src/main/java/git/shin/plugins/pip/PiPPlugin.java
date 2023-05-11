package git.shin.plugins.pip;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "PiP")
public class PiPPlugin extends Plugin {
    private PiP pip;

    @Override
    public void load() {
        pip = new PiP(getActivity());
        pip.setOnPipModeChangedListener(new PiP.OnPipModeChangedListener() {
            @Override
            public void onPipModeChanged(boolean isInPipMode) {
                JSObject data = new JSObject();
                data.put("isInPipMode", isInPipMode);
                notifyListeners("pipModeChanged", data);
            }
        });
    }

    @PluginMethod
    public void enterPip(PluginCall call) {
        float width = call.getFloat("width", 1.0f);
        float height = call.getFloat("height", 1.0f);
        pip.enterPip(width, height);
        call.resolve();
    }

    @PluginMethod
    public void isPipSupported(PluginCall call) {
        JSObject result = new JSObject();
        result.put("isSupported", pip.isPipSupported());
        call.resolve(result);
    }

    @Override
    protected void handleOnConfigurationChanged() {
        super.handleOnConfigurationChanged();
        pip.onConfigurationChanged(getContext().getResources().getConfiguration());
    }
}