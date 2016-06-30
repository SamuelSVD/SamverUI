del "C:\Programming\processingjava\Images\frame-00001.tif"
del "C:\Programming\processingjava\Images\video.mp4"
ffmpeg -i frame-%%05d.tif -start_number 0000 -framerate 30 -r 30 -threads 4 video.mp4