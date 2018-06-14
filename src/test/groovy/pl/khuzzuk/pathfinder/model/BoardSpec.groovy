package pl.khuzzuk.pathfinder.model

import spock.lang.Specification
import spock.lang.Unroll

class BoardSpec extends Specification {
    @Unroll
    def 'check place creation'() {
        given:
        Board board = Board.cleanBoardOfSize(3, 3)

        when:
        def place = board.placeFor(x, y)

        then:
        place.center == Field.CLEAR
        place.top == top
        place.bottom == bottom
        place.left == left
        place.right == right

        where:
        x || y || bottom      || top         || left        || right
        1 || 1 || Field.CLEAR || Field.CLEAR || Field.CLEAR || Field.CLEAR
        1 || 0 || Field.CLEAR || null        || Field.CLEAR || Field.CLEAR
        1 || 2 || null        || Field.CLEAR || Field.CLEAR || Field.CLEAR
        0 || 1 || Field.CLEAR || Field.CLEAR || null        || Field.CLEAR
        2 || 1 || Field.CLEAR || Field.CLEAR || Field.CLEAR || null
        0 || 0 || Field.CLEAR || null        || null        || Field.CLEAR
        2 || 0 || Field.CLEAR || null        || Field.CLEAR || null
        0 || 2 || null        || Field.CLEAR || null        || Field.CLEAR
        2 || 2 || null        || Field.CLEAR || Field.CLEAR || null
    }
}
