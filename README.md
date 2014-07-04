GWT-MVP
=======

Example of GWT project using Activities and Places

**App**

[Manifest](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/mvp.gwt.xml) - Specify's MyApp.java as the EntryPoint to the application.

[MyApp.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/MyApp.java) - Implements EntryPoint defining the onModuleLoad method which will start the application.

**Model**

  * Responsible for holding raw data
  * This shouldn't contain any business logic.

[Person.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/shared/Person.java)

**View**

 * Resonsible for displaying data
 * Allows UiBinder to pass through UiHandler methods to the Presenter

[PersonView.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/views/PersonView.java) - Interface to define a PersonView.

[PeronViewImpl.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/views/PersonViewImpl.java) - Implementation of a PersonView. This shouldn't contain any business logic.

[PersonViewImpl.ui.xml](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/views/PersonViewImpl.ui.xml) - Template that can contain either HTML or GWT Widgets.

**ClientFactory**

* Holds on to instances of views and other reusable system resources

[ClientFactory.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/ClientFactory.java)

[ClientFactoryImpl.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/ClientFactoryImpl.java)

**Activity**

  * Presenter with "bells and whistles".
  * Has lifecycle events - navigated away, activity's widget (view it controls) is removed from view, etc
  * Implements the Presenter interface defined in the view above

[PersonActivity.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/activities/PersonActivity.java)

**Place**

  * Most Activities have an associated Place
  * Extends Place
  * Usually has a Tokenizer defined as an inner public class
    * Implements PlaceTokenizer<BlahPlace>

[PersonPlace.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/places/PersonPlace.java)

**PlaceHistoryMapper**

  * A way to let GWT know about your history tokenizers
  * Link between PlaceTokenizers and GWT's history mechanism (PlaceHistory_Handler_)

[AppPlaceHistoryMapper.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/AppPlaceHistoryMapper.java)

**ActivityMapper**

  * A way to map each Place to some Activity. Remember that Activity implements presenter so an Activity is a Presenter
  * Used to automatically route app to an Activity

[AppActivityMapper.java](https://github.com/gdks/GWT-MVP/blob/activitiesandplaces/src/com/gfi/training/gwtmvp/client/AppActivityMapper.java)

