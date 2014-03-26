package sh.calaba.instrumentationbackend.actions.map;

import sh.calaba.instrumentationbackend.InstrumentationBackend;
import sh.calaba.instrumentationbackend.Result;
import sh.calaba.instrumentationbackend.actions.Action;

/**
 * @author Nicholas Albion
 */
public class SetMapZoom implements Action {

    @Override
    public Result execute(String... args) {
    	if( "in".equals(args[0]) ) {
    		return new Result( InstrumentationBackend.solo.zoomInOnMap() );
    	} else if( "out".equals(args[0]) ) {
    		return new Result( InstrumentationBackend.solo.zoomOutOnMap() );
    	}
    	
    	int requestedZoomLevel = Integer.parseInt(args[0]);
        InstrumentationBackend.solo.setMapZoom( requestedZoomLevel );
        float updatedZoomLevel = InstrumentationBackend.solo.getMapZoom();

        if( updatedZoomLevel == requestedZoomLevel ) {
        	return Result.successResult();
        } else {
        	return new Result(false, "Requested zoom level: " + requestedZoomLevel + " but current zoom level is " + updatedZoomLevel);
        }
    }

    @Override
    public String key() {
        return "set_map_zoom";
    }
}