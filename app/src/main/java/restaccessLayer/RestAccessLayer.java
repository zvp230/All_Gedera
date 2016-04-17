package restaccessLayer;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.IOException;

/**
 * Created by Alex on 1/9/2016.
 */
public class RestAccessLayer /*implements Response.Listener<Event[]>, Response.ErrorListener*/ {

    private static RestAccessLayer dataAccess;
    private RequestQueue rQueue;

    private RestAccessLayer() {
    };

    public static RestAccessLayer getInstance(Context context) throws IOException {
        if (dataAccess == null) {
            synchronized (RestAccessLayer.class) {
                if (dataAccess == null) {
                    dataAccess = new RestAccessLayer();
                    if(context == null) {
                        throw new IOException("Context is null.Provide correct context");
                    }
                    dataAccess.rQueue =Volley.newRequestQueue(context);
                }
            }
        }
        return dataAccess;
    }

    /*public void runJsonRequestGetEvent(final RestCallback.OnResponseSuccess ors, final RestCallback.OnResponseFailure orf) throws IOException {
        String url = Constants.url;
        final Request jsonRequest = new GsonRequest<> (url, Event[].class, new Response.Listener<Event[]>(){
            @Override
            public void onResponse(Event[] response) {
                ors.onSuccess(response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                    orf.onFailure(error);
        }
        });
        rQueue.add(jsonRequest);
    }

    public void runJsonRequestGetCoupons(final RestCallback.OnResponseSuccess ors, final RestCallback.OnResponseFailure orf) throws IOException {
        String url = Constants.url;
        final Request jsonRequest = new GsonRequest<> (url, Coupon[].class, new Response.Listener<Coupon[]>(){
            @Override
            public void onResponse(Coupon[] response) {
                ors.onSuccess(response);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                orf.onFailure(error);
            }
        });
        rQueue.add(jsonRequest);
    }
*/
}
