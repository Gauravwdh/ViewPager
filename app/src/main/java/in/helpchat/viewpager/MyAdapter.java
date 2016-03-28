package in.helpchat.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gauravwadhwa on 28/03/16.
 */
public class MyAdapter extends FragmentStatePagerAdapter {

    private Map<Integer, Fragment> map;

    public MyAdapter(FragmentManager fm) {
        super(fm);
        map = new HashMap<>();
    }

    @Override
    public Fragment getItem(int position) {
        if (map.containsKey(position)) {
            return map.get(position);
        } else {
            Log.d("TAG","Created : "+position);
            TestFragment testFragment = new TestFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("index", position);
            testFragment.setArguments(bundle);
            map.put(position, testFragment);
            return getItem(position);
        }
    }

    @Override
    public int getCount() {
        return 100;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        Log.d("TAG", "removed: " + position);
        map.remove(position);
        super.destroyItem(container, position, object);
    }
}
