//package example.com.azalea;
//
//import android.content.Context;
//import android.net.Uri;
//import android.os.Bundle;
//import android.support.v4.app.Fragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.google.android.gms.maps.CameraUpdateFactory;
//import com.google.android.gms.maps.GoogleMap;
//import com.google.android.gms.maps.MapView;
//import com.google.android.gms.maps.MapsInitializer;
//import com.google.android.gms.maps.OnMapReadyCallback;
//import com.google.android.gms.maps.model.CameraPosition;
//import com.google.android.gms.maps.model.LatLng;
//import com.google.android.gms.maps.model.MarkerOptions;
//
//
//public class MapViewFragment extends Fragment {
//    MapView mMapView;
//    private GoogleMap googleMap;
//
//    public MapViewFragment(){
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
//       View rootView = inflater.inflate(R.layout.fragment_map_view, container, false);
//
//        mMapView = (MapView) rootView.findViewById(R.id.mapView);
//        mMapView.onCreate(savedInstanceState);
//
//        mMapView.onResume(); //needed to get the map to display immediately
//
//        try{
//            MapsInitializer.initialize(getActivity().getApplicationContext());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//
//        mMapView.getMapAsync(new OnMapReadyCallback() {
//            @Override
//            public void onMapReady(GoogleMap mMap) {
//                googleMap = mMap;
//
//                //for showing a move to my location button
//                try {
//                    googleMap.setMyLocationEnabled(true);
//                }catch(SecurityException se){} //figure out security exceptions and `checkPermission`
//
//                //****Latitude and Longitude markers are make and dropped here****
//                LatLng PACLatLng = new LatLng(38.993492, -77.127302);
//                googleMap.addMarker(new MarkerOptions().position(PACLatLng).title("PAC Auditorium"));
//
//                LatLng bearStore = new LatLng(38.993150, -77.126514);
//                googleMap.addMarker(new MarkerOptions().position(bearStore).title("Bear Store")); //TODO ask for name of store during festival
//
//                LatLng foodArea = new LatLng(38.993262, -77.125916);
//                googleMap.addMarker(new MarkerOptions().position(foodArea).title("Food/Dining area"));
//
//                LatLng shoppingArea = new LatLng(38.991232, -77.126806);
//                googleMap.addMarker(new MarkerOptions().position(shoppingArea).title("Shopping/Art Sale"));
//
//                LatLng ridesArea = new LatLng(38.992470, -77.126827);
//                googleMap.addMarker(new MarkerOptions().position(ridesArea).title("Rides and Food"));
//                //****************************************************************
//
//                //for zooming automatically to the location of the marker
//                CameraPosition cameraPosition = new CameraPosition.Builder().target(PACLatLng).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
//                cameraPosition = new CameraPosition.Builder().target(bearStore).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
//                cameraPosition = new CameraPosition.Builder().target(foodArea).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
//                cameraPosition = new CameraPosition.Builder().target(shoppingArea).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
//                cameraPosition = new CameraPosition.Builder().target(ridesArea).zoom(12).build();
//                googleMap.animateCamera(CameraUpdateFactory.newCameraPosition((cameraPosition)));
//                //this may work idk yet
//            }
//        });
//        return rootView;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//    }
//
//    @Override
//    public void onResume(){
//        super.onResume();
//        mMapView.onResume();
//    }
//
//    @Override
//    public void onPause(){
//        super.onPause();
//        mMapView.onPause();
//    }
//
//    @Override
//    public void onDestroy(){
//        super.onDestroy();
//        mMapView.onDestroy();
//    }


//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;
//
//    private OnFragmentInteractionListener mListener;
//
//    public MapViewFragment() {
//        // Required empty public constructor
//    }
//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment MapViewFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static MapViewFragment newInstance(String param1, String param2) {
//        MapViewFragment fragment = new MapViewFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_map_view, container, false);
//    }
//
//    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
//    }
//
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }
//
//    /**
//     * This interface must be implemented by activities that contain this
//     * fragment to allow an interaction in this fragment to be communicated
//     * to the activity and potentially other fragments contained in that
//     * activity.
//     * <p/>
//     * See the Android Training lesson <a href=
//     * "http://developer.android.com/training/basics/fragments/communicating.html"
//     * >Communicating with Other Fragments</a> for more information.
//     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
//}
