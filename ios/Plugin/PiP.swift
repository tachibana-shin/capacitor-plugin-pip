import Foundation

@objc public class PiP: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
