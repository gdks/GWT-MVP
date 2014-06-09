GWT-MVP
=======

Example of GWT project using Activities and Places

**Model**

  * Responsible for holding raw data
  * No business logic

**View**


**ClientFactory**

* Holds on to instances of views and other reusable system resources

**Activity**

  * Presenter with "bells and whistles".
  * Has lifecycle events - navigated away, activity's widget (view it controls) is removed from view, etc
  * Implements the Presenter interface defined in the view above

**Place**

  * Most Activities have an associated Place
  * Extends Place
  * Usually has a Tokenizer defined as an inner public class
    * Implements PlaceTokenizer<BlahPlace>

**PlaceHistoryMapper**

  * A way to let GWT know about your history tokenizers
  * Link between PlaceTokenizers and GWT's history mechanism (PlaceHistory_Handler_)

**ActivityMapper**

  * A way to map each Place to some Activity. Remember that Activity implements presenter so an Activity is a Presenter
  * Used to automatically route app to an Activity
