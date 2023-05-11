import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(PiPPlugin)
public class PiPPlugin: CAPPlugin {
    @objc func enterPip(_ call: CAPPluginCall) {
        call.reject("Picture-in-Picture mode not supported on this platform")
    }

    @objc func isPipSupported(_ call: CAPPluginCall) {
        call.resolve([
            "isSupported": false
        ])
    }
}