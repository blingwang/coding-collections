package com.blingwang.playground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author edward
 */
public class Tracker {
    private Map<String, Set<Integer>> serversByType = new HashMap<>();

    private static class Server {
        String type;
        int id;

        Server(String type, int id) {
            this.type = type;
            this.id = id;
        }
    }

    public String allocate(String serverType) {
        int id = nextServerNumber(serverType);
        serversByType.get(serverType).add(id);
        return serverType + id;
    }

    public void deallocate(String serverName) {
        Server server = parseServerName(serverName);
        if (server == null) {
            return;
        }

        if (!serversByType.containsKey(server.type)) {
            return;
        }

        Set<Integer> ids = serversByType.get(server.type);
        if (!ids.contains(server.id)) {
            return;
        }

        ids.remove(server.id);
    }

    private int nextServerNumber(String serverType) {
        if (!serversByType.containsKey(serverType)) {
            serversByType.put(serverType, new HashSet<>());
        }
        Set<Integer> ids = serversByType.get(serverType);

        int totalServers = ids.size();
        for (int i = 1; i <= totalServers; i++) {
            if (!ids.contains(i)) {
                return i;
            }
        }

        return totalServers + 1;
    }

    private Server parseServerName(String name) {
        Pattern p = Pattern.compile("^([a-zA-Z]+)(\\d)+$");
        Matcher m = p.matcher(name);

        if (m.find()) {
            String type = m.group(1);
            int id = Integer.valueOf(m.group(2));
            return new Server(type, id);
        }

        return null;
    }

    public static int nextServerNumber(int[] nums) {
        Set<Integer> positives = new HashSet<>();

        for (int n : nums) {
            if (n > 0) {
                positives.add(n);
            }
        }

        int totalPositives = positives.size();
        for (int i = 1; i <= totalPositives; i++) {
            if (!positives.contains(i)) {
                return i;
            }
        }

        return totalPositives + 1;
    }

    public static <T> void assertEquals(T expected, T actual) {
        if (expected == null && actual == null || actual != null && actual.equals(expected)) {
            System.out.println("PASSED");
        } else {
            throw new AssertionError("Expected:\n  " + expected + "\nActual:\n  " + actual + "\n");
        }
    }

    public static void main(String[] args) {
        assertEquals(1, Tracker.nextServerNumber(new int[0]));
        assertEquals(3, Tracker.nextServerNumber(new int[]{5, 1, 2}));
        assertEquals(2, Tracker.nextServerNumber(new int[]{-2, 1, 3, 0}));
        assertEquals(3, Tracker.nextServerNumber(new int[]{2, 1, 4, 1}));
        assertEquals(5, Tracker.nextServerNumber(new int[]{1, 2, 3, 4}));
        assertEquals(1, Tracker.nextServerNumber(new int[]{5, 4, 3, 2}));
        assertEquals(4, Tracker.nextServerNumber(new int[]{3, 1, 2, 100}));

        Tracker tracker = new Tracker();
        assertEquals("apibox1", tracker.allocate("apibox"));
        assertEquals("apibox2", tracker.allocate("apibox"));
        tracker.deallocate("apibox1");
        assertEquals("apibox1", tracker.allocate("apibox"));
        assertEquals("sitebox1", tracker.allocate("sitebox"));
    }
}
