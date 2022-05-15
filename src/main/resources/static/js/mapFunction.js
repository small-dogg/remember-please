navigator.geolocation.getCurrentPosition(function (position) {
    //사용자 위치 정보 동의 및 위치 정보 수집
    console.log(position);

    //Ajax Call을 통해, 사용자 위치 기반 날씨 정보 수집 및 출력
    $.ajax({
        type: 'get',
        url: "/weather",
        data: {
            latitude: position.coords.latitude,
            longitude: position.coords.longitude
        },
        success: function (data) {
            console.log(data);
        },
        error: function (error) {
            console.log(error);
        }
    });
});