package by.azarkevich.task1.comparator;

import by.azarkevich.task1.entity.IntArray;
import by.azarkevich.task1.exception.IntArrayException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;

public enum IntArrayComparator implements Comparator<IntArray> {
    ID {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by ID");
            return Long.compare(first.getId(), second.getId());
        }
    },
    SIZE {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by SIZE");
            return Integer.compare(first.size(), second.size());
        }
    },
    FIRST_ELEMENT {
        @Override
        public int compare(IntArray first, IntArray second) {
            logger.info("Compare by FIRST_ELEMENT");
            try {
                int firstValue = first.size() == 0 ? Integer.MIN_VALUE : first.get(0);
                int secondValue = second.size() == 0 ? Integer.MIN_VALUE : second.get(0);
                return Integer.compare(firstValue, secondValue);
            } catch (IntArrayException e) {
                throw new IllegalStateException("Could not compare first elements", e);
            }
        }
    };

    private static final Logger logger = LogManager.getLogger(IntArrayComparator.class);
}
