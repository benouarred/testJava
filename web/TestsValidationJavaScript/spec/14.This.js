describe('This', function(){

    it("This - 1", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + _;
            }
        };
        expect(person.intro()).toBe("Hello, my name is bob");
    });


    it("This - 2", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var alias = person.intro;

        window.name = 'Peter';

        expect( _ ).toBe("Hello, my name is Peter");
    });


    it("This - 3", function () {
        var person = {
            name: 'bob',
            intro: function () {
                return "Hello, my name is " + this.name;
            }
        };

        var message = person.intro.call( _ );
        expect(message).toBe("Hello, my name is Frank");
    });



});