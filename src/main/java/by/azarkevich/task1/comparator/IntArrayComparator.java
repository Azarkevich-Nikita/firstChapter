package by.azarkevich.task1.comparator;

import by.azarkevich.task1.entity.IntArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public enum IntArrayComparator implements Comparator<IntArray> {
    BY_ID {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by BY_ID");
            return Long.compare(first.getId(), second.getId());
        }
    },
    BY_LENGTH {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by BY_LENGTH");
            return Integer.compare(first.size(), second.size());
        }
    },
    BY_FIRST_ELEMENT {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by BY_FIRST_ELEMENT");
            int val1 = first.size() > 0 ? first.getArray()[0] : 0;
            int val2 = second.size() > 0 ? second.getArray()[0] : 0;
            return Integer.compare(val1, val2);
        }
    };

    private static final Logger logger = LogManager.getLogger(IntArrayComparator.class);
}
