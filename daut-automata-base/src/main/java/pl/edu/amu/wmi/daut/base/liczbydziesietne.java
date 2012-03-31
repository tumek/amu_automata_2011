/**
* Automat akceptujacy liczby dziesietne (napisy z zerami nieznaczacymi
* nie powinny byc akceptowane)
**/

    public final void testLiczbyDziesietne()
    {
            final AutomatonSpecification spec = new NaiveAutomatSpecification();

            State q0 = spec.addState();

State q1 = spec.addState();
State q2 = spec.addState();
State q3 = spec.addState();
State q4 = spec.addState();

spec.addTransition(q0, q1, new CharTransitionLabel('1,2,3,4,5,6,7,8,9'));
spec.addTransition(q0, q3, new CharTransitionLabel('-'));
spec.addTransition(q1, q1, new CharTransitionLabel('0,1,2,3,4,5,6,7,8,9'));
spec.addTransition(q1, q2, new CharTransitionLabel(','));
spec.addTransition(q3, q4, new CharTransitionLabel('1,2,3,4,5,6,7,8,9'));
spec.addTransition(q4, q4, new CharTransitionLabel('0,1,2,3,4,5,6,7,8,9'));
spec.addTransition(q4, q2, new CharTransitionLabel(','));
spec.addTransition(q1, q2, new CharTransitionLabel(','));
spec.addTransition(q4, q2, new CharTransitionLabel(','));
spec.addTransition(q2, q2, new CharTransitionLabel('0,1,2,3,4,5,6,7,8,9'));

spec.markAsInitial(q0);
spec.markAsFinal(q2);

AutomatonByStack automaton = new AutomatonByStack(spec);
assertFalse(automaton.accepts("111"));
assertTrue(automaton.accepts("1,23"));
assertTrue(automaton.accepts("2,34"));
assertFalse(automaton.accepts("33.879"));
assertFalse(automaton.accepts("lalalalalalalalla"));
assertTrue(automaton.accepts("10,56949"));
assertTrue(automaton.accepts("1,2"));
assertFalse(automaton.accepts("0,7"));
assertFalse(automaton.accepts("0,09"));
assertTrue(automaton.accepts("90,000000000000000000009"));
assertTrue(automaton.accepts("3,14"));
assertFalse(automaton.accepts("kghm"));
assertFalse(automaton.accepts("&^dssss^&"));
assertTrue(automaton.accepts("56,123"));
assertTrue(automaton.accepts("-3,4"));
assertTrue(automaton.accepts("-3,0000004"));
assertFalse(automaton.accepts("--------------"));
assertFalse(automaton.accepts(" "));
assertTrue(automaton.accepts("-2,23453455"))

}
}

